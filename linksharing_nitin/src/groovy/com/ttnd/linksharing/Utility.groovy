package com.ttnd.linksharing

class Utility {

    static String generatePassword() {
        String password = UUID.randomUUID()
        password = password.tokenize('-')[0]
        return password
    }
}
