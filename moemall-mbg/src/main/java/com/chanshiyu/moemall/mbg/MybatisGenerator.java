package com.chanshiyu.moemall.mbg;

import org.mybatis.generator.api.*;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.util.List;
import java.util.Objects;

/**
 * 自动生成实体类属性注解
 */
public class MybatisGenerator extends PluginAdapter {

    public static void main(String[] args) {
        generate();
    }

    public static void generate() {
        String config = Objects.requireNonNull(MybatisGenerator.class.getClassLoader().getResource("generator/generatorConfig.xml")).getFile();
        String[] arg = { "-configfile", config, "-overwrite" };
        ShellRunner.main(arg);
    }

    @Override
    public boolean validate(List<String> list) {
        return true;
    }

    /**
     * 实体类添加swagger注解
     */
    @Override
    public boolean modelFieldGenerated(Field field, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn,
                                       IntrospectedTable introspectedTable, Plugin.ModelClassType modelClassType) {
        String classAnnotation = "@ApiModel(value=\"" + topLevelClass.getType().getShortName() + "\")";
        if (!topLevelClass.getAnnotations().contains(classAnnotation)) {
            topLevelClass.addAnnotation(classAnnotation);
        }
        String apiModelAnnotationPackage = this.properties.getProperty("apiModelAnnotationPackage");
        String apiModelPropertyAnnotationPackage = this.properties.getProperty("apiModelPropertyAnnotationPackage");
        if (null == apiModelAnnotationPackage) {
            apiModelAnnotationPackage = "io.swagger.annotations.ApiModel";
        }
        if (null == apiModelPropertyAnnotationPackage) {
            apiModelPropertyAnnotationPackage = "io.swagger.annotations.ApiModelProperty";
        }
        topLevelClass.addImportedType(apiModelAnnotationPackage);
        topLevelClass.addImportedType(apiModelPropertyAnnotationPackage);
        field.addAnnotation("@ApiModelProperty(value=\"" + introspectedColumn.getRemarks() +
                "\",name=\""+introspectedColumn.getJavaProperty()+
                "\",dataType=\""+introspectedColumn.getFullyQualifiedJavaType().getShortName()+
                "\")");
        return super.modelFieldGenerated(field, topLevelClass, introspectedColumn, introspectedTable, modelClassType);
    }

}