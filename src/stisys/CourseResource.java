package demo.stisys2;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Path("courses")
public class CourseResource {
    private static Map<Integer, Course> map;
    private static AtomicInteger counter = new AtomicInteger();

    static {
        map = new ConcurrentHashMap<>();
        Instant instant = Instant.now();
        map.put(1, new Course(1, "SE"));
        map.put(2, new Course(2, "DC"));
        map.put(3, new Course(3, "DSP"));
        counter.set(3);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Course> getAllStudentAsJson() {
        StringBuilder stringBuilder = new StringBuilder();
        List<Course> list = map.values().stream()
                .collect(Collectors.toList());
        return list;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newCourse(@Context UriInfo uriInfo, Course course) {
        int id = counter.incrementAndGet();
        course.setId(id);
        map.put(id, course);
        URI location = uriInfo.getAbsolutePathBuilder().path(String.valueOf(id)).build();
        return Response.created(location).build();
    }
}
