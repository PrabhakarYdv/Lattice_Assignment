package com.prabhakar.lattice_assignment.view

import com.prabhakar.lattice_assignment.remote.model.ArticlesModel
import com.prabhakar.lattice_assignment.remote.model.ResponseModel

interface OnClickListener {

    fun onClick(model: ArticlesModel, position: Int)

}