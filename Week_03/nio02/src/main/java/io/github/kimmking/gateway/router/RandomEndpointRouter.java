package io.github.kimmking.gateway.router;

import java.util.List;
import java.util.Random;

/**
 * @author Fzy
 * @version 1.0
 * @date 2020/11/5 0:33
 */
public class RandomEndpointRouter   implements HttpEndpointRouter {
    private static final Random RANDOM = new Random();

    @Override
    public String route(List<String> endpoints) {
        int index = RANDOM.nextInt(endpoints.size());
        return  endpoints.get(index);
    }
}
