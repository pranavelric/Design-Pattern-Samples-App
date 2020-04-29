/**
 *
 * Copyright 2020 David Odari
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *            http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 *
 **/
package com.github.odaridavid.designpatterns

import com.github.odaridavid.designpatterns.decorator.ChristmasBarDecorator
import com.github.odaridavid.designpatterns.decorator.CollegeBar
import com.github.odaridavid.designpatterns.decorator.HalloweenBarDecorator
import com.github.odaridavid.designpatterns.decorator.SportsBar
import org.junit.Test


class DecoratorPatternUnitTest {

    @Test
    fun decoratorTest() {
        val sportsBar = SportsBar()
        val collegeBar = CollegeBar()

        HalloweenBarDecorator(sportsBar).setup()
        ChristmasBarDecorator(collegeBar).setup()
    }
}