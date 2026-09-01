package com.swyp.features.mypage.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.swyp.core.navigation.PickpleNavRoute
import com.swyp.features.mypage.account.Account
import com.swyp.features.mypage.account.AccountRoute
import com.swyp.features.mypage.appinfo.AppInfo
import com.swyp.features.mypage.appinfo.AppInfoRoute
import com.swyp.features.mypage.grade.Grade
import com.swyp.features.mypage.grade.GradeRoute
import com.swyp.features.mypage.history.ActivityHistory
import com.swyp.features.mypage.history.ActivityHistoryRoute
import com.swyp.features.mypage.main.MyPage
import com.swyp.features.mypage.main.MyPageRoute
import kotlinx.serialization.Serializable

@Serializable
data object MyPageNavGraph : PickpleNavRoute

fun NavGraphBuilder.myPageGraph(
    onProfileClick: () -> Unit,
    navController: NavHostController
) {
    navigation<MyPageNavGraph>(
        startDestination = MyPage
    ){
        composable<MyPage> {
            MyPageRoute(
                onProfileClick = onProfileClick,
                onActivityHistoryClick = {
                    navController.navigate(ActivityHistory)
                },
                onAccountClick = {
                    navController.navigate(Account)
                },
                onGradeClick = {
                    navController.navigate(Grade)
                },
                onAppInfoClick = {
                    navController.navigate(AppInfo)
                }
            )
        }
        composable<Account> { AccountRoute() }
        composable<AppInfo> { AppInfoRoute() }
        composable<Grade> { GradeRoute() }
        composable<ActivityHistory> { ActivityHistoryRoute() }
    }
}
