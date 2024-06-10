cd ..\

PROJECT_VERSION=$(mvn help:evaluate -Dexpression=project.version -q -DforceStdout)
echo "project version: ${PROJECT_VERSION}"

mvn install:install-file -Dfile="notify-service-client/target/notify-service-client-${PROJECT_VERSION}.jar" -DgroupId="com.surikat.documents" -DartifactId="notify-service-client" -Dversion="${PROJECT_VERSION}" -Dpackaging=jar