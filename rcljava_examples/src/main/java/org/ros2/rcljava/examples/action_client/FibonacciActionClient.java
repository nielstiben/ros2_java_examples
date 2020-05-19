///* Copyright 2020 Niels Tiben <nielstiben@outlook.com>
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// *     http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//
//package org.ros2.rcljava.examples.action_client;
//
//import example_interfaces.action.Fibonacci;
//import example_interfaces.action.Fibonacci_Feedback;
//import example_interfaces.action.Fibonacci_Goal;
//import example_interfaces.action.Fibonacci_Result;
//import example_interfaces.srv.AddTwoInts_Response;
//import org.ros2.rcljava.RCLJava;
//import org.ros2.rcljava.action_client.ActionClient;
//import org.ros2.rcljava.concurrent.Callback;
//import org.ros2.rcljava.interfaces.MessageDefinition;
//import org.ros2.rcljava.node.BaseComposableNode;
//import org.ros2.rcljava.timer.WallTimer;
//
//import java.util.concurrent.ExecutionException;
//import java.util.concurrent.Future;
//import java.util.concurrent.TimeUnit;
//
//public class FibonacciActionClient extends BaseComposableNode {
//    private ActionClient<Fibonacci> actionClient;
//
//    public FibonacciActionClient() throws NoSuchFieldException, IllegalAccessException, ExecutionException, InterruptedException {
//        super("minimal_action_client_java");
//
//        Task task = new Task();
//
//
//        // Let's create a new Node
//        actionClient = node.createActionClient(
//                example_interfaces.action.Fibonacci.class,
//                "/fibonacci",
//                (Fibonacci_Result msg) -> System.out.println("Result: [" + msg.getSequence() + "]"),
//                (Fibonacci_Feedback msg) -> System.out.println("Feedback: [" + msg.toString() + "]")
//        );
//
//        //Thread thread = new Thread(task);
//        //thread.start();
//
//        task.run();
//
//
//        System.out.println("reached! :)");
//    }
//
//    public static void main(String[] args) throws InterruptedException, NoSuchFieldException, IllegalAccessException, ExecutionException {
//        // Initialize RCL
//        RCLJava.rclJavaInit();
//
//        RCLJava.spin(new FibonacciActionClient());
//    }
//
//    private class Task implements Runnable {
//
//        @Override
//        public void run() {
//            try {
//                Thread.sleep(700);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            Fibonacci_Goal goal = new Fibonacci_Goal();
//            goal.setOrder(8);
//
//            Future<MessageDefinition> future = actionClient.asyncSendGoalRequest(goal.setOrder(9));
//            System.out.println("Break point");
//
//            MessageDefinition result = null;
//            try {
//                result = future.get();
//            } catch (InterruptedException | ExecutionException e) {
//                e.printStackTrace();
//            }
//
//            if (result != null) {
//                System.out.println(
//                        "result of " + goal.getOrder() + " = " + result.toString());
//            } else {
//                System.out.println("Result is null");
//            }
//            RCLJava.shutdown();
//        }
//    }
//}
