package untitled

class FilterFilters {

    def filters = {
        traceUris(uri:'/api/**') {
            before = {
                println '-------Mirchi sunne wale always khus---------------------------'
                def map = [:]
                map << params
                log.debug("${new Date()}")
                map.each { k, v -> log.debug("${k}:${v}") }
                // do some preprocessing request
            }
            after = {
                // do some postprocessing
            }

        }
        traceUris(uri:'/api/**/**') {
            before = {
                println '-------Mirchi sunne wale always khus---------------------------'
                def map = [:]
                map << params
                log.debug("${new Date()}")
                map.each { k, v -> log.debug("${k}:${v}") }
                // do some preprocessing request
            }
            after = {
                // do some postprocessing
            }

        }
    }
}
