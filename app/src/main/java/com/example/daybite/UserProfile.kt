package com.example.daybite

data class UserProfile(var firstName : String ?= null, var lastName : String ?= null, var userEmail : String ?= null,var userPassword : String ?= null, var userDateOfBirth : Int ?= null)
