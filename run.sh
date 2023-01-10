nohup java -Dspring.profiles.active=hirist-production -jar target/demo-0.0.1-SNAPSHOT.jar &
sleep 5
tail -f nohup.out
