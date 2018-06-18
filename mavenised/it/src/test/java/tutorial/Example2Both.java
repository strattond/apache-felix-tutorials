package tutorial;

import static org.junit.Assert.*;
import static org.ops4j.pax.exam.CoreOptions.*;

import javax.inject.Inject;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Configuration;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.PaxExam;
import org.ops4j.pax.exam.options.MavenArtifactProvisionOption;
import org.ops4j.pax.exam.options.MavenArtifactUrlReference;
import org.ops4j.pax.exam.options.MavenUrlReference;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;

import tutorial.example2.service.DictionaryService;

@RunWith(PaxExam.class)
public class Example2Both
{
  @Inject
  private BundleContext bundleContext;

  private List< DictionaryService > dictService;

  @Configuration
  public static Option[] configuration()
  {
    // http://veithen.github.io/alta/examples/pax-exam.html
   return options( cleanCaches( true ), junitBundles(), 
     url( "link:classpath:example2.service.link" ),
     url( "link:classpath:example2b.link" ),
     url( "link:classpath:example2.link" )
   );
  }

  @Before
  public void setup() throws Exception
  {
    dictService = new ArrayList<>();
    ServiceTracker tracker = new ServiceTracker( bundleContext, DictionaryService.class.getName(), null );
    tracker.open();
    tracker.waitForService( 5000 );
    ServiceReference[] services = tracker.getServiceReferences();
    for( ServiceReference o : services )
    {
      dictService.add( (DictionaryService)tracker.getService( o ) );
    }    
    tracker.close();
  }

  private boolean checkWord( String word )
  {
    for( DictionaryService d : dictService )
    {
      if( d.checkWord( word ) ) return true;
    }
    return false;
  }

  @Test
  public void wordInListEnglish()
  {
    assertTrue( "The word was not spelled correctly", checkWord( "welcome" ) );
  }

  @Test
  public void wordInListFrench()
  {
    assertTrue( "The word was not spelled correctly", checkWord( "bienvenue" ) );
  }

  @Test
  public void wordNotInList()
  {
    assertFalse( "The word was spelled correctly", checkWord( "welocme" ) );
  }
}