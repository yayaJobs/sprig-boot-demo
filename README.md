# sprig-boot-demo
java sprig-boot demo
gradle bootRun


export apphome=/home/cmsdev
start(){
 now=`date "+%Y%m%d%H%M%S"`
 exec $JAVA ${JAVA_OPT}  -DAPP_HOME=$apphome -jar /home/cmsdev/jar/cms-web-0.0.2-SNAPSHOT.jar --spring.config.location=file:/home/cmsdev/properties/  5 > /home/cmsdev/logs/cms_web_"$now".log &
}