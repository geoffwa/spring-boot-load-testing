package pivotal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;

import static java.lang.Math.atan;
import static java.lang.Math.cbrt;
import static java.lang.Math.tan;

@SpringBootApplication
@RestController
public class PerftestApplication {

	public static void main(String[] args) {
		SpringApplication.run(PerftestApplication.class, args);
	}

	@GetMapping("/io")
    public String io() throws InterruptedException {
        long sleepDuration = 200L + (long) (500L * Math.random());
        Thread.sleep(sleepDuration);
        return "done after " + sleepDuration + "ms";
    }

}
