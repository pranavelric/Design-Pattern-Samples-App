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

import com.github.odaridavid.designpatterns.bridge.Chair
import com.github.odaridavid.designpatterns.bridge.VintageFurnitureShop
import org.junit.Test


class BridgePatternUnitTest {

    @Test
    fun setAmbienceEffects_vintageShop_returnVintageFurniture() {
        val chair = Chair()
        val vintageShop = VintageFurnitureShop("8:00 AM - 5:00 PM", chair)

        vintageShop.setVintageAmbience()

        assert(chair.getAmbience() == "Vintage")

    }
}