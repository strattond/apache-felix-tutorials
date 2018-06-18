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

import tutorial.example6.service.SpellChecker;

@RunWith(PaxExam.class)
public class Example9French
{
  @Inject
  private BundleContext bundleContext;

  @Inject
  private SpellChecker spellService;

  @Configuration
  public static Option[] configuration()
  {
    // http://veithen.github.io/alta/examples/pax-exam.html
   return options( cleanCaches( true ), junitBundles(), 
     mavenBundle( "org.apache.felix", "org.apache.felix.scr", "2.1.0" ),
     mavenBundle( "org.apache.felix", "org.apache.felix.scr.annotations", "1.12.0" ),
     url( "link:classpath:example2.service.link" ),
     url( "link:classpath:example2b.link" ),
     url( "link:classpath:example6.service.link" ),
     url( "link:classpath:example9.link" )
   );
  }

  @Test
  public void nullMeansPass()
  {
    assertNull( "A null string should pass", spellService.check( null ) );
  }

  @Test
  public void emptyMeansPass()
  {
    assertNull( "An empty string should pass", spellService.check( "" ) );
  }

  @Test
  public void goodPhrase()
  {
    assertNull( "The phrase is spelled correctly", spellService.check( "bienvenue au tutoriel osgi" ) );
  }

  @Test
  public void oneBadWord()
  {
    String [] badWords = spellService.check( "beinvenue au tutoriel osgi" );
    assertNotNull( "The phrase has no word errors", badWords );
    assertEquals( "Only one word should be bad", badWords.length, 1 );
  }
}