# Zoo Simulator API Endpoints

|Resources    |HTTP Verb|Resource URL                              |Use Representation Case               |
|-------------|---------|------------------------------------------|--------------------------------------|
|Zoo          |GET      |/zoo/1/TicketShop/1                       |Visit ticket shop                     |
|Animals      |POST     |/TicketShop/1/Tickets                     |Visitor buys new unique ticket        |
|Hospital     |GET      |/visitor/1/tickets/1                      |Visitor showing valid ticket          |
|Enclosure    |GET      |/Enclosure/1/animals                      |Visitor goes to animal enclosure      |
|Gift Shops   |POST     |/animals/1/tasks/1/feeds                  |Visitor feeds animals                 |
|Buildings    |GET      |/Buildings/1/GiftShops/2                  |Visitor goes to gift shop             |
|Tickets      |POST     |/GiftShops/2/tasks/1/buyGift              |Visitor buys souveneir                |
|Veterinarians|GET      |/Buildings/1/Hospital/1                   |Visitor goes to hospital              |
|Ticket Shops |POST     |/Hospital/1/Veterinarian/1/tasks/1/lecture|Visitor listens to lecture            |
|             |DELETE   |/visitor/1/tickets/1                      |Visitor loses access to zoo and leaves|
