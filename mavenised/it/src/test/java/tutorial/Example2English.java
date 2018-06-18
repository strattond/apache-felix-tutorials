package tutorial;

import static org.junit.Assert.*;
import static org.ops4j.pax.exam.CoreOptions.*;

import javax.inject.Inject;

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
public class Example2English
{
  @Inject
  private BundleContext bundleContext;

  @Inject
  private DictionaryService dictService;

  @Configuration
  public static Option[] configuration()
  {
    // http://veithen.github.io/alta/examples/pax-exam.html
   return options( cleanCaches( true ), junitBundles(), 
     url( "link:classpath:example2.service.link" ),
     url( "link:classpath:example2.link" )
   );
  }

  @Test
  public void wordInList()
  {
    assertTrue( "The word was not spelled correctly", dictService.checkWord( "welcome" ) );
  }

  @Test
  public void wordNotInList()
  {
    assertFalse( "The word was spelled correctly", dictService.checkWord( "welocme" ) );
  }
}