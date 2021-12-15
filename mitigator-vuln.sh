#!/bin/sh
java -Dlog4j2.formatMsgNoLookups=true -classpath apache-log4j-2.14.0-bin/log4j-core-2.14.0.jar:apache-log4j-2.14.0-bin/log4j-api-2.14.0.jar:. log4poc $@
