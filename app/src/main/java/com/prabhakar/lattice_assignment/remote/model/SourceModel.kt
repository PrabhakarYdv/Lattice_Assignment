package com.prabhakar.lattice_assignment.remote.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SourceModel(

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("name")
	val name: String? = null
)