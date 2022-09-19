package by.atmm.kotlin.sburrest

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/droid")
class DroidController(@get:GetMapping val droid: Droid)