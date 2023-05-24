package com.example.kotlinflowdemo.repository

import com.example.kotlinflowdemo.model.CommentModel
import com.example.kotlinflowdemo.network.ApiService
import kotlinx.coroutines.flow.flowOn
import com.example.kotlinflowdemo.network.CommentApiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CommentsRepository(private val apiService: ApiService) {
    suspend fun getComment(id: Int): Flow<CommentApiState<CommentModel>> {
        return flow {

            // get the comment Data from the api
            val comment=apiService.getComments(id)

            // Emit this data wrapped in
            // the helper class [CommentApiState]
            emit(CommentApiState.success(comment))
        }.flowOn(Dispatchers.IO)
    }
}