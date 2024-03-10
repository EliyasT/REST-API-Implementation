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

@Path("students")
public class StudentResource {
	private static Map<Integer, Student> map;
	private static AtomicInteger counter = new AtomicInteger();

	static {
		map = new ConcurrentHashMap<>();
		Instant instant = Instant.now();
		map.put(1, new Student(1, "James Smith", "IE", 2));
		map.put(2, new Student(2, "Anna Potter", "IE",5 ));
		map.put(3, new Student(3, "Justin Jack", "IE",6));
		counter.set(3);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getAllMessagesAsJson() {
		StringBuilder stringBuilder = new StringBuilder();
		List<Student> list = map.values().stream()
				.collect(Collectors.toList());
		return list;
	}


	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response newMessage(@Context UriInfo uriInfo, Student student) {
		int id = counter.incrementAndGet();
		student.setId(id);
		map.put(id, student);
		URI location = uriInfo.getAbsolutePathBuilder().path(String.valueOf(id)).build();
		return Response.created(location).build();
	}


}
