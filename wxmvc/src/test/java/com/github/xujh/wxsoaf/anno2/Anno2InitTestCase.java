package com.github.xujh.wxsoaf.anno2;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.ClassUtils;
import org.springframework.util.ReflectionUtils.MethodFilter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethodSelector;
import org.springframework.web.servlet.mvc.condition.RequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;

import com.github.xujh.wxsoaf.annotation.RequestType;
import com.github.xujh.wxsoaf.stereotype.WxController;

public class Anno2InitTestCase {
	ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext(
			"classpath:com/github/xujh/wxsoaf/anno2/spring-con2.xml");

	@Test
	public void test4LinkRequest() {

		Map<String, Object> map = app
				.getBeansWithAnnotation(WxController.class);
		for (String name : map.keySet()) {
			System.out.println("name -->: " + name);
			WxController anno = app.findAnnotationOnBean(name,
					WxController.class);
			System.out.println(anno.toString());
			RequestType[] types = anno.type();
			for (RequestType type : types) {
				if (RequestType.link.equals(type)) {
					System.out.println(" name of type 1:" + type);
				} else {
					System.out.println(" name of type 2:" + type);
				}
				
				detectHandlerMethods(this.getApplicationContext().getBean(name));
			}
		}

	}

	protected void detectHandlerMethods(final Object handler) {
		Class<?> handlerType = (handler instanceof String) ? getApplicationContext()
				.getType((String) handler) : handler.getClass();

		final Class<?> userType = ClassUtils.getUserClass(handlerType);
		System.out.println(" name of type 3:" + userType);
		Set<Method> methods = HandlerMethodSelector.selectMethods(userType,
				new MethodFilter() {
					public boolean matches(Method method) {
						return getMappingForMethod(method, userType) != null;
					}
				});

		for (Method method : methods) {
			System.out.println(" name of type 4:" + method.getName());
			// T mapping = getMappingForMethod(method, userType);
			// registerHandlerMethod(handler, method, mapping);
		}
	}

	private AbstractApplicationContext getApplicationContext() {
		return app;
	}

	protected RequestMappingInfo getMappingForMethod(Method method,
			Class<?> handlerType) {
		RequestMappingInfo info = null;
		RequestMapping methodAnnotation = AnnotationUtils.findAnnotation(
				method, RequestMapping.class);
		if (methodAnnotation != null) {
			RequestCondition<?> methodCondition = getCustomMethodCondition(method);
			info = createRequestMappingInfo(methodAnnotation, methodCondition);
			RequestMapping typeAnnotation = AnnotationUtils.findAnnotation(
					handlerType, RequestMapping.class);
			if (typeAnnotation != null) {
				RequestCondition<?> typeCondition = getCustomTypeCondition(handlerType);
				info = createRequestMappingInfo(typeAnnotation, typeCondition)
						.combine(info);
			}
		}
		return info;
	}

	private RequestMappingInfo createRequestMappingInfo(
			RequestMapping annotation, RequestCondition<?> customCondition) {
		// String[] patterns =
		// resolveEmbeddedValuesInPatterns(annotation.value());
		// return new RequestMappingInfo(new PatternsRequestCondition(patterns,
		// getUrlPathHelper(), getPathMatcher(),
		// this.useSuffixPatternMatch, this.useTrailingSlashMatch,
		// this.fileExtensions), new RequestMethodsRequestCondition(
		// annotation.method()), new ParamsRequestCondition(
		// annotation.params()), new HeadersRequestCondition(
		// annotation.headers()), new ConsumesRequestCondition(
		// annotation.consumes(), annotation.headers()),
		// new ProducesRequestCondition(annotation.produces(), annotation
		// .headers(), getContentNegotiationManager()),
		// customCondition);

		return null;
	}

	protected RequestCondition<?> getCustomMethodCondition(Method method) {
		return null;
	}

	protected RequestCondition<?> getCustomTypeCondition(Class<?> handlerType) {
		return null;
	}
}
