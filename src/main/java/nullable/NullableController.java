package nullable;

import javax.annotation.Nullable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;

@Controller("/nullable")
public class NullableController {
	private static final Logger LOG = LoggerFactory.getLogger(NullableController.class);

	// success
	@Post(uri = "/string", consumes = MediaType.MULTIPART_FORM_DATA)
	public HttpResponse<?> stringVersion(@Body @Nullable String firstname) {
		return HttpResponse.ok(firstname);
	}

	// failure
	@Post(uri = "/long", consumes = MediaType.MULTIPART_FORM_DATA)
	public HttpResponse<?> longVersion(@Body @Nullable Long quantity) {
		return HttpResponse.ok(quantity);
	}
}
