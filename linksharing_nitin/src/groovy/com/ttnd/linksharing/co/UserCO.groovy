package com.ttnd.linksharing.co

class UserCO {
    String email
    String username
    String password
    String firstName
    String lastName
    Boolean admin = false
    Boolean active = true
    Byte[] photo
    String confirmPassword

    String toString() {
        "${email}:${username}:${firstName}:${lastName}:${photo}"
    }

}
