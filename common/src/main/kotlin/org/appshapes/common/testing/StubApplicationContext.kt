package org.appshapes.common.testing

import org.springframework.beans.factory.BeanFactory
import org.springframework.beans.factory.ObjectProvider
import org.springframework.beans.factory.config.AutowireCapableBeanFactory
import org.springframework.beans.factory.config.BeanFactoryPostProcessor
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationListener
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.MessageSourceResolvable
import org.springframework.core.ResolvableType
import org.springframework.core.env.ConfigurableEnvironment
import org.springframework.core.io.ProtocolResolver
import org.springframework.core.io.Resource
import org.springframework.core.metrics.ApplicationStartup
import java.util.*

@ExcludeFromGeneratedCoverage
class StubApplicationContext : ConfigurableApplicationContext {
    var closeCalled: Boolean = false

    override fun getEnvironment(): ConfigurableEnvironment {
        TODO("Not yet implemented")
    }

    override fun getBean(name: String): Any {
        TODO("Not yet implemented")
    }

    override fun <T : Any> getBean(name: String, requiredType: Class<T>): T {
        TODO("Not yet implemented")
    }

    override fun getBean(name: String, vararg args: Any?): Any {
        TODO("Not yet implemented")
    }

    override fun <T : Any> getBean(requiredType: Class<T>): T {
        TODO("Not yet implemented")
    }

    override fun <T : Any> getBean(requiredType: Class<T>, vararg args: Any?): T {
        TODO("Not yet implemented")
    }

    override fun <T : Any?> getBeanProvider(requiredType: Class<T>, allowEagerInit: Boolean): ObjectProvider<T> {
        TODO("Not yet implemented")
    }

    override fun <T : Any?> getBeanProvider(requiredType: ResolvableType, allowEagerInit: Boolean): ObjectProvider<T> {
        TODO("Not yet implemented")
    }

    override fun <T : Any?> getBeanProvider(requiredType: Class<T>): ObjectProvider<T> {
        TODO("Not yet implemented")
    }

    override fun <T : Any?> getBeanProvider(requiredType: ResolvableType): ObjectProvider<T> {
        TODO("Not yet implemented")
    }

    override fun containsBean(name: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun isSingleton(name: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun isPrototype(name: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun isTypeMatch(name: String, typeToMatch: ResolvableType): Boolean {
        TODO("Not yet implemented")
    }

    override fun isTypeMatch(name: String, typeToMatch: Class<*>): Boolean {
        TODO("Not yet implemented")
    }

    override fun getType(name: String): Class<*>? {
        TODO("Not yet implemented")
    }

    override fun getType(name: String, allowFactoryBeanInit: Boolean): Class<*>? {
        TODO("Not yet implemented")
    }

    override fun getAliases(name: String): Array<String> {
        TODO("Not yet implemented")
    }

    override fun containsBeanDefinition(beanName: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun getBeanDefinitionCount(): Int {
        TODO("Not yet implemented")
    }

    override fun getBeanDefinitionNames(): Array<String> {
        TODO("Not yet implemented")
    }

    override fun getBeanNamesForType(type: ResolvableType): Array<String> {
        TODO("Not yet implemented")
    }

    override fun getBeanNamesForType(type: ResolvableType, includeNonSingletons: Boolean, allowEagerInit: Boolean): Array<String> {
        TODO("Not yet implemented")
    }

    override fun getBeanNamesForType(type: Class<*>?): Array<String> {
        TODO("Not yet implemented")
    }

    override fun getBeanNamesForType(type: Class<*>?, includeNonSingletons: Boolean, allowEagerInit: Boolean): Array<String> {
        TODO("Not yet implemented")
    }

    override fun <T : Any?> getBeansOfType(type: Class<T>?): MutableMap<String, T> {
        TODO("Not yet implemented")
    }

    override fun <T : Any?> getBeansOfType(type: Class<T>?, includeNonSingletons: Boolean, allowEagerInit: Boolean): MutableMap<String, T> {
        TODO("Not yet implemented")
    }

    override fun getBeanNamesForAnnotation(annotationType: Class<out Annotation>): Array<String> {
        TODO("Not yet implemented")
    }

    override fun getBeansWithAnnotation(annotationType: Class<out Annotation>): MutableMap<String, Any> {
        TODO("Not yet implemented")
    }

    override fun <A : Annotation?> findAnnotationOnBean(beanName: String, annotationType: Class<A>): A? {
        TODO("Not yet implemented")
    }

    override fun <A : Annotation?> findAnnotationOnBean(beanName: String, annotationType: Class<A>, allowFactoryBeanInit: Boolean): A? {
        TODO("Not yet implemented")
    }

    override fun getParentBeanFactory(): BeanFactory? {
        TODO("Not yet implemented")
    }

    override fun containsLocalBean(name: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun getMessage(code: String, args: Array<out Any>?, defaultMessage: String?, locale: Locale): String? {
        TODO("Not yet implemented")
    }

    override fun getMessage(code: String, args: Array<out Any>?, locale: Locale): String {
        TODO("Not yet implemented")
    }

    override fun getMessage(resolvable: MessageSourceResolvable, locale: Locale): String {
        TODO("Not yet implemented")
    }

    override fun publishEvent(event: Any) {
        TODO("Not yet implemented")
    }

    override fun getResource(location: String): Resource {
        TODO("Not yet implemented")
    }

    override fun getClassLoader(): ClassLoader? {
        TODO("Not yet implemented")
    }

    override fun getResources(locationPattern: String): Array<Resource> {
        TODO("Not yet implemented")
    }

    override fun getId(): String? {
        TODO("Not yet implemented")
    }

    override fun getApplicationName(): String {
        TODO("Not yet implemented")
    }

    override fun getDisplayName(): String {
        TODO("Not yet implemented")
    }

    override fun getStartupDate(): Long {
        TODO("Not yet implemented")
    }

    override fun getParent(): ApplicationContext? {
        TODO("Not yet implemented")
    }

    override fun getAutowireCapableBeanFactory(): AutowireCapableBeanFactory {
        TODO("Not yet implemented")
    }

    override fun start() {
        TODO("Not yet implemented")
    }

    override fun stop() {
        TODO("Not yet implemented")
    }

    override fun isRunning(): Boolean {
        TODO("Not yet implemented")
    }

    override fun close() {
        closeCalled = true
    }

    override fun setId(id: String) {
        TODO("Not yet implemented")
    }

    override fun setParent(parent: ApplicationContext?) {
        TODO("Not yet implemented")
    }

    override fun setEnvironment(environment: ConfigurableEnvironment) {
        TODO("Not yet implemented")
    }

    override fun setApplicationStartup(applicationStartup: ApplicationStartup) {
        TODO("Not yet implemented")
    }

    override fun getApplicationStartup(): ApplicationStartup {
        TODO("Not yet implemented")
    }

    override fun addBeanFactoryPostProcessor(postProcessor: BeanFactoryPostProcessor) {
        TODO("Not yet implemented")
    }

    override fun addApplicationListener(listener: ApplicationListener<*>) {
        TODO("Not yet implemented")
    }

    override fun setClassLoader(classLoader: ClassLoader) {
        TODO("Not yet implemented")
    }

    override fun addProtocolResolver(resolver: ProtocolResolver) {
        TODO("Not yet implemented")
    }

    override fun refresh() {
        TODO("Not yet implemented")
    }

    override fun registerShutdownHook() {
        TODO("Not yet implemented")
    }

    override fun isActive(): Boolean {
        TODO("Not yet implemented")
    }

    override fun getBeanFactory(): ConfigurableListableBeanFactory {
        TODO("Not yet implemented")
    }
}