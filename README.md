# graphql

Endpoint. http://localhost:8080/graphiql?path=/user

# Mutation. (create & delete)

mutation {
createOrder(order: {
orderDetail: "Amazon order",
address: "Odisha",
price: 100,
userId: 2
}){
orderId,
orderDetail
}
}

mutation {
deleteUser(userId:1)
}

# Query. (get & get all)

query {
getUser(userId:2) {
name,
email
}
}

query {
getUsers {
name,
email,
orders {
orderDetail
address
price
}
}
}