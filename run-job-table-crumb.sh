#/bin/bash

crumb=$(curl -u "jenkins:12345" -s 'http://localhost:8000/crumbIssuer/api/xml?xpath=concat(//crumbRequestField,":",//crumb)')

curl -u "jenkins:12345" -H "$crumb" -X POST  http://localhost:8000/job/ansible-users-db/buildWithParameters?AGE=22
