dataSource {
    pooled = true
    jmxExport = true
    //driverClassName = "org.h2.Driver"
    driverClassName = "com.mysql.jdbc.Driver"
    username = "root"
    password = "igdefault"
}
hibernate {
    cache.use_second_level_cache = false
    cache.use_query_cache = false
//    cache.region.factory_class = 'org.hibernate.cache.SingletonEhCacheRegionFactory' // Hibernate 3
    cache.region.factory_class = 'org.hibernate.cache.ehcache.SingletonEhCacheRegionFactory' // Hibernate 4
    singleSession = true // configure OSIV singleSession mode
    flush.mode = 'manual' // OSIV session flush mode outside of transactional context
}

// environment specific settings
environments {
    development {
        dataSource {
            dbCreate = "update"
//            dbCreate = "create-drop"
            url = "jdbc:mysql://localhost:3306/linksharing"
//            logSql = true
        }
    }
    test {
        dataSource {
            dbCreate = "update"
//            url = "jdbc:h2:mem:testDb;MVCC=TRUE;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE"
            url = "jdbc:mysql://localhost:3306/linksharing"


        }
    }
    production {
        dataSource {
            dbCreate = "update"
            uri = new URI(System.env.DATABASE_URL ?: "mysql://root:igdefault@localhost")
           username = uri.userInfo ? uri.userInfo.split(":")[0] : ""
           password = uri.userInfo ? uri.userInfo.split(":")[1] : ""
           url = "jdbc:mysql://" + uri.host + uri.path
            properties {
                // See http://grails.org/doc/latest/guide/conf.html#dataSource for documentation
                jmxEnabled = true
                initialSize = 5
                maxActive = 50
                minIdle = 5
                maxIdle = 25
                maxWait = 10000
                maxAge = 10 * 60000
                timeBetweenEvictionRunsMillis = 5000
                minEvictableIdleTimeMillis = 60000
                validationQuery = "SELECT 1"
                validationQueryTimeout = 3
                validationInterval = 15000
                testOnBorrow = true
                testWhileIdle = true
                testOnReturn = false
                jdbcInterceptors = "ConnectionState"
                defaultTransactionIsolation = java.sql.Connection.TRANSACTION_READ_COMMITTED
            }
        }
    }
}
