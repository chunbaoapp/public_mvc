package chunbao.nl.event.gui.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// scan for spring beans
@ComponentScan({"chunbao.nl.event.gui"})
@Configuration
public class MyConfiguration {
  @Value("${readonly.server.url}")
  private String readonlyServerUrl;

  public String getReadonlyServerUrl() {
    return readonlyServerUrl;
  }
}
