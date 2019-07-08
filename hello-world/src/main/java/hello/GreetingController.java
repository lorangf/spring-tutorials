package hello;

@RestController
public class GreetingController {

    private final static String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(method="GET", value="/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}