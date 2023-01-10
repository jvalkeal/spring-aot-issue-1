package com.example.demo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class DemoRegistrar implements ImportBeanDefinitionRegistrar {

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		Set<Class<?>> types = new HashSet<>(Arrays.asList(String.class));
		ConstructorArgumentValues cav = new ConstructorArgumentValues();
		cav.addIndexedArgumentValue(0, types);
		RootBeanDefinition definition = new RootBeanDefinition(Holder.class, cav, null);
		registry.registerBeanDefinition("holder", definition);
	}

	public static class Holder {
		Set<Class<?>> types;

		public Set<Class<?>> getTypes() {
			return types;
		}

		public void setTypes(Set<Class<?>> types) {
			this.types = types;
		}

		@Override
		public String toString() {
			return "Holder [types=" + types + "]";
		}
	}
}
