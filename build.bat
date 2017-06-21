cd service-registry
call mvnw.cmd install
cd ..

cd event-service
call mvnw.cmd install
cd ..

cd calendar-service
call mvnw.cmd install
cd ..
