package com.tinder.redditapp

import com.tinder.redditapp.data.model.ChildData
import com.tinder.redditapp.data.model.Children
import com.tinder.redditapp.data.repository.PostRepository
import com.tinder.redditapp.ui.theme.viewmodel.HomeViewModel
import io.mockk.coEvery
import com.tinder.redditapp.data.Result
import com.tinder.redditapp.ui.theme.viewmodel.UIState
import io.mockk.coVerifyAll
import io.mockk.impl.annotations.MockK
import io.mockk.junit4.MockKRule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestCoroutineScheduler
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import java.lang.Exception

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@OptIn(ExperimentalCoroutinesApi::class)
class HomeViewModelTest {

    private lateinit var homeViewModel: HomeViewModel
    @get:Rule
    val mockkRule = MockKRule(this)

    val scheduler = TestCoroutineScheduler()
    private val dispatcher = StandardTestDispatcher(scheduler)
    @MockK
    lateinit var repository: PostRepository
    private val children = listOf(Children("kind", ChildData()))

    @Before
    fun setUp() {
        Dispatchers.setMain(dispatcher)
        homeViewModel = HomeViewModel(repository)

        coEvery {
            repository.getListOfPost()
        } returns flow { emit(Result.Success(children)) }
    }
    @Test
    fun test_when_fetchPost_Success() = runTest{

        homeViewModel.fetchPost()
        dispatcher.scheduler.advanceUntilIdle()

        coVerifyAll {
            repository.getListOfPost()
        }
        assertEquals(UIState.Success(children), homeViewModel.combinedFlow.value)
    }

    @Test
    fun test_when_fetchPost_Failure() = runTest{

        coEvery {
            repository.getListOfPost()
        } returns flow { emit(Result.Error(Exception())) }

        homeViewModel.fetchPost()
        dispatcher.scheduler.advanceUntilIdle()

        coVerifyAll {
            repository.getListOfPost()
        }
        assertEquals(UIState.Error(errorMessage = null), homeViewModel.combinedFlow.value)
    }

    @After
    fun close() {
        Dispatchers.resetMain()
    }
}
