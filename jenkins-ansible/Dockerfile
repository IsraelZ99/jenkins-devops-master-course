FROM jenkins/jenkins:jdk11

USER root

RUN apt-get update
RUN apt-get install -y python

RUN curl https://bootstrap.pypa.io/pip/2.7/get-pip.py -o get-pip.py && \
    python get-pip.py && \
    python -m pip install ansible

USER jenkins
