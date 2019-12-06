package com.example.aidlsampleapp.ViewModel

import android.view.View
import androidx.lifecycle.MutableLiveData
import com.example.aidlsampleapp.network.PostApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Ajeena on 06-12-2019.
 * Claysol MediaLabs Pvt Ltd
 * ajeena.sainudeen@claysol.com
 *
 */
class PostViewModel : BaseViewModel() {
    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    @Inject
    lateinit var postApi: PostApi

    private lateinit var subscription: Disposable

    init{
        loadPosts()
    }

    private fun loadPosts(){
        subscription = postApi.getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { onRetrievePostListStart() }
                .doOnTerminate { onRetrievePostListFinish() }
                .subscribe(
                        { onRetrievePostListSuccess() },
                        { onRetrievePostListError() }
                )
    }

    private fun onRetrievePostListStart(){
        loadingVisibility.value = View.VISIBLE
    }

    private fun onRetrievePostListFinish(){
        loadingVisibility.value = View.GONE
    }

    private fun onRetrievePostListSuccess(){

    }

    private fun onRetrievePostListError(){

    }
    /** dispose subscription property when the ViewModel is no longer used and will be destroyed**/
    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }
}