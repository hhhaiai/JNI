/*
 * Copyright (C) 2010 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

#ifndef DALVIK_ALLOC_VERIFY_H_
#define DALVIK_ALLOC_VERIFY_H_

#include "../oo/Object.h"
#include "HeapBitmap.h"

/*
 * Verifies an object reference.
 */
void dvmVerifyObject(const Object *obj);

/*
 * Verifies the object references in a heap bitmap. Assumes the VM is
 * suspended.
 */
void dvmVerifyBitmap(const HeapBitmap *bitmap);

/*
 * Verifies the contents of various global roots.
 */
void dvmVerifyRoots(void);

#endif  // DALVIK_ALLOC_VERIFY_H_
