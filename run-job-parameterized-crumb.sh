#/bin/bash

crumb=$(curl -u "jenkins:12345" -s 'http://localhost:8000/crumbIssuer/api/xml?xpath=concat(//crumbRequestField,":",//crumb)')

curl -u "jenkins:12345" -H "$crumb" -X POST  http://localhost:8000/job/backup-to-aws/buildWithParameters?MYSQL_HOST=db_host&DATABASE_NAME=testdb&AWS_BUCKET_NAME=jenkins-backup-mysql-iz

