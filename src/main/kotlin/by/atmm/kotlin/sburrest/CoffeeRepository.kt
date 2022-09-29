package by.atmm.kotlin.sburrest

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CoffeeRepository : CrudRepository<Coffee, String> {
}
