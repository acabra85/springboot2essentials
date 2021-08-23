package com.acabra.webapp.spring;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Configuration
@ComponentScan({"com.acabra.webapp.control"})
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void extendMessageConverters(final List<HttpMessageConverter<?>> converters) {
        Stream.of(findJsonMapper(converters), findXmlMapper(converters))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .forEach(this::enableSerializationAndDeserializationFeatures);
    }

    private void enableSerializationAndDeserializationFeatures(ObjectMapper mapper) {
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    private Optional<ObjectMapper> findXmlMapper(List<HttpMessageConverter<?>> converters) {
        Optional<HttpMessageConverter<?>> xmlConverterFound = converters.stream()
                .filter(c -> c instanceof MappingJackson2XmlHttpMessageConverter)
                .findFirst();
        return xmlConverterFound.map(httpMessageConverter -> ((MappingJackson2XmlHttpMessageConverter) httpMessageConverter)
                .getObjectMapper());
    }

    private Optional<ObjectMapper> findJsonMapper(List<HttpMessageConverter<?>> converters) {
        final Optional<HttpMessageConverter<?>> jsonConverterFound = converters.stream()
                .filter(c -> c instanceof AbstractJackson2HttpMessageConverter)
                .findFirst();
        return jsonConverterFound.map(httpMessageConverter -> ((AbstractJackson2HttpMessageConverter) httpMessageConverter)
                .getObjectMapper());
    }
}
