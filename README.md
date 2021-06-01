1. Run Test
$ gradlew test

2. Build package
$ gradlew build

3. Run application
$ java -jar ./build/libs/jarFile.jar

4. Available commands

a. CASH_IN <Amount>

b. ADD_BILL <Service Name> <Provider Name> <Amount> <Due Date>

c. UPDATE_BILL (TODO)

d. REMOVE_BILL <Bill No>

e. LIST_BILL

f. SEARCH_BILL_BY_PROVIDER <Provider Name>

g. LIST_PAYMENT

h. DUE_DATE (TODO)

i. SCHEDULE <Bill No> <Payment Date> (TODO)
