package com.ttnd.linksharing

enum UserStatus {
    ALL_USERS('All Users'), ACTIVE('Active'), INACTIVE('Inactive')

    final String value

    UserStatus(String value) {
        this.value = value
    }

    String toString() { value }

    String getKey() { name() }

}