1.Run Test
$ gradlew test

2.Build package
$ gradlew build

3.Run application
$ java -jar ./build/libs/jarFile.jar

4.Available commands

- CASH_IN <Amount>

- ADD_BILL <Service Name> <Provider Name> <Amount> <Due Date>

- UPDATE_BILL (TODO)

- REMOVE_BILL <Bill No>

- LIST_BILL

- SEARCH_BILL_BY_PROVIDER <Provider Name>

- LIST_PAYMENT

- DUE_DATE (TODO)

- SCHEDULE <Bill No> <Payment Date> (TODO)
