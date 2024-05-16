# 使用一个基础镜像
FROM openjdk:17-jdk-alpine

# 设置工作目录
WORKDIR /app

# 复制应用的 JAR 文件到容器中
COPY target/service-essay-0.0.1-SNAPSHOT.jar app.jar

# 暴露服务的端口号
EXPOSE 8886

# 容器启动时执行的命令
ENTRYPOINT ["java", "-jar", "app.jar"]
