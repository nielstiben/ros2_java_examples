/* Copyright 2020 Niels Tiben <nielstiben@outlook.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.ros2.rcljava.examples.action_client;

import example_interfaces.action.Fibonacci;
import example_interfaces.action.Fibonacci_Feedback;
import example_interfaces.action.Fibonacci_Goal;
import example_interfaces.action.Fibonacci_Result;
import org.ros2.rcljava.RCLJava;
import org.ros2.rcljava.action_client.ActionClient;
import org.ros2.rcljava.node.Node;

import java.lang.reflect.Type;

public class FibonacciActionClient {
    private static final Type T = Fibonacci_Feedback.class;

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        // Initialize RCL
        RCLJava.rclJavaInit();

        // Let's create a new Node
        Node node = RCLJava.createNode("minimal_action_client");

        ActionClient<Fibonacci> actionClient = node.createActionClient(
                example_interfaces.action.Fibonacci.class,
                "/fibonacci",
                (Fibonacci_Result msg) -> System.out.println("Result: [" + msg.getSequence() + "]"),
                (Fibonacci_Feedback msg) -> System.out.println("Feedback: [" + msg.toString() + "]")
        );
        System.out.println("reached! :)");
    }
}
