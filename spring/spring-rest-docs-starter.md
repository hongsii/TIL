
## dependency 추가

```
<dependency>
  <groupId>org.springframework.restdocs</groupId>
  <artifactId>spring-restdocs-mockmvc</artifactId>
  <scope>test</scope>
</dependency>
```

maven에서 dependency를 찾지 못하는 경우 터미널을 사용해 프로젝트 경로에서 `./mvnw package` 실행하면 세팅 완료

----------

Rest Docs는 컨트롤러의 테스트를 문서화시켜줌

Rest Docs 수동 설정

``` java
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
public class MappingTestControllerTest {

	@Rule
	public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation(); // public 아니면 에러

	private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(MappingTestController.class)
				.apply(documentationConfiguration(restDocumentation))
				.build();
	}

	@Test
	public void test() throws Exception {
		mockMvc.perform(get("/test/param?mapping=hello"))
				.andExpect(status().isOk())
				.andDo(document("hello"));
	}
}
```

Rest Docs 자동 설정

``` java
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(MappingTestController.class)
@AutoConfigureRestDocs(outputDir = "target/snippets")
public class MappingTestControllerTest2 {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void test() throws Exception {
		mockMvc.perform(get("/test/param?mapping=hello"))
				.andExpect(status().isOk())
				.andDo(document("hello"));
	}
}
```

-------------

* [Creating API Documentation with Restdocs](https://spring.io/guides/gs/testing-restdocs/)

