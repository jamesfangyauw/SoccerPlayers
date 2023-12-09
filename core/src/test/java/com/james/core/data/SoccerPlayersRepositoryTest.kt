//package com.james.core.data
//
//import com.james.core.data.source.local.LocalDS
//import com.james.core.data.source.local.entity.SoccerPlayerEntity
//import com.james.core.data.source.remote.RemoteDS
//import com.james.core.data.source.remote.network.ApiResponse
//import com.james.core.utils.ApplicationExecutors
//import com.james.core.utils.DataDummy
//import com.james.core.utils.DataMapper
//import kotlinx.coroutines.flow.flow
//import kotlinx.coroutines.flow.flowOf
//import kotlinx.coroutines.runBlocking
//import org.junit.Assert.*
//import org.junit.Before
//import org.junit.Test
//import org.junit.runner.RunWith
//import org.mockito.Mock
//import org.mockito.Mockito
//import org.mockito.junit.MockitoJUnitRunner
//
//@RunWith(MockitoJUnitRunner::class)
//class SoccerPlayersRepositoryTest {
//
//    @Mock
//    private lateinit var remoteDataSource: RemoteDS
//
//    @Mock
//    private lateinit var localDataSource: LocalDS
//
//    @Mock
//    private lateinit var appExecutors: ApplicationExecutors
//
//    private lateinit var playerRepository: SoccerPlayersRepository
//
//    @Before
//    fun setUp() {
//        playerRepository = SoccerPlayersRepository(remoteDataSource, localDataSource, appExecutors)
//    }
//
//    @Test
//    fun `make sure getAllPlayer() is not null`() = runBlocking {
//        // Given
//        val emptyList: List<SoccerPlayerEntity> = emptyList()
//        val flowList = flowOf(emptyList)
//
//        Mockito.`when`(localDataSource.getAllSoccerPlayer()).thenReturn(flowList)
//        Mockito.`when`(remoteDataSource.getAllListSoccerPlayer())
//            .thenReturn(flowOf(ApiResponse.Success(listOf())))
//
//        // When
//        val resultFlow = playerRepository.getAllListSoccerPlayer()
//
//        // Then
//        assertNotNull(resultFlow)
//    }
//
//    @Test
//    fun `make sure getAllPlayer() returns correct value`() = runBlocking {
//        // Given
//        val playerList = DataDummy.generateDummyPlayer()
//        val flowList = flowOf(playerList)
//
//        Mockito.`when`(localDataSource.getAllSoccerPlayer()).thenReturn(flowList)
//        Mockito.`when`(remoteDataSource.getAllListSoccerPlayer()).thenReturn(flow {
//            ApiResponse.Success(playerList)
//        })
//
//        // When
//        val resultFlow = playerRepository.getAllListSoccerPlayer()
//
//        // Then
//        resultFlow.collect { resource ->
//            when (resource) {
//                is ResultCustom.Loading -> {
//                    // Handle loading state if needed
//                }
//                is ResultCustom.Success -> {
//                    val data = resource.dataResponse
//                    val playerListFromFlow = data?.map { DataMapper.mapDomainToEntity(it) }
//                    // Perform assertions on the data
//                    assertEquals(playerList[0], playerListFromFlow?.get(0))
//                }
//                is ResultCustom.Error -> {
//                    // Handle error state if needed
//                }
//            }
//        }
//    }
//}