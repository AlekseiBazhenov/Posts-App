package ru.lifehacker.testapp

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dagger.hilt.android.AndroidEntryPoint
import ru.lifehacker.testapp.screens.PostDetails
import ru.lifehacker.testapp.screens.Posts

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = "posts") {
                composable("posts") {
                    Posts() {
                        navController.navigate("post_details/$it")
                    }
                }
                composable(
                    route = "post_details/{content}",
                    arguments = listOf(
                        navArgument("content") { type = NavType.StringType }
                    )
                ) {
                    it.arguments?.getString("content")?.let { content -> PostDetails(content) }
                }
            }
        }
    }
}
