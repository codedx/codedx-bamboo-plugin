# For now, the openjdk8 image gives us Ubuntu with OpenJDK 8
FROM adoptopenjdk/openjdk8:latest
MAINTAINER Robert Ferris <robert.ferris@codedx.com>

# install the atlassian SDK
RUN apt-get -qq update && \
	apt-get -qqy install curl gnupg && \
	curl https://packages.atlassian.com/api/gpg/key/public | apt-key add - && \
	echo "deb https://packages.atlassian.com/atlassian-sdk-deb stable contrib" >>/etc/apt/sources.list && \
	apt-get -qq update && \
	apt-get -qqy install atlassian-plugin-sdk