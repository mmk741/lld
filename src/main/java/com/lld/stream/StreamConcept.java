package com.lld.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public  class StreamConcept {
    public static void main(String[] args) {

        //https://notebook.zohopublic.in/public/notes/74tdod05928d081b5484fbfd5937d4129fa64
        //Predicate, Function ,Consumer
//        Stream : 1.create stream
//                 2. intermediate operation
//                 3.terminal operation
        //Stream are mainly usefull when we have bulk of data and want to do parallel process

        //Different ways to create stream
        //1.stream from collection
        List<Integer> salaryList= Arrays.asList(11,23,123,233,12);
        Stream<Integer> stream = salaryList.stream();

        //2. from array
        Integer[] salaryArray=new Integer[]{1,22,333,123};
        Stream<Integer> stream1 = Arrays.stream(salaryArray);

        //3. from static method Stream.of
        Stream<Integer> streamfromStaticMethod = Stream.of(1,2,3,1);

        //4 from streamBuilder
        Stream<Object> streamFromBuilder = Stream.builder().add(100).add(200).add(800).build();

        //5(startPoint , IncrementLogic,limit)
        Stream<Integer> streamFromIterator = Stream.iterate(800, (Integer n) -> n + 50).limit(5);
        streamFromIterator.forEach((x)-> System.out.println("stream from itterator: "+x));


        //Intermediate operation : it is a lazy operation
        //1.filter
        List<Integer> collectFilter = stream.filter(x -> x > 23).collect(Collectors.toList());
        System.out.println("Filtered Data: " + collectFilter);

        //2.map use to transform each element
        //. In Java Streams, once a terminal operation is invoked on a stream, the stream is considered closed, and you cannot perform additional operations on it.
        List<Integer> collectMap = stream1.map(x -> x + 10).collect(Collectors.toList());
        System.out.println("Mapped Data: " + collectMap);

        //3.FlatMAp :  use to iterate over each element of complex collection and help to flatten it
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8, 9)
        );

        // Use flatMap to flatten the list of lists into a single stream of integers
        Stream<Integer> flattenedStream = listOfLists.stream()
                .flatMap(List::stream);

        // Print the elements of the flattened stream
        System.out.println("flattened stream : "+flattenedStream.collect(Collectors.toList()));

        //4.distinct : remove duplicate from array

        List<Integer> collectDistinct = streamfromStaticMethod.distinct().collect(Collectors.toList());
        System.out.println("distinct element: "+ collectDistinct);

        //5.sorted
        //6.peek
        //7.limit
        //8.skip : it will skip first n element
        //9.mapToInt : help to work with primitive int data type
        //when we work with primitive data type and do stream on it we get IntStream in case of int
        //and not Stream, so when IntStream is collected we get primitive data type
        //10.mapToLong
        //11.mapToDouble


        //3.Terminal operation
        //1.forEach: consumer as input
        //2.toArray()
        //3.reduce
        //4.collect
        //5. min , max
        //6. count
        //7. anyMatch : return boolean
        //8. allMatch , noneMatch
        //9.findFirst , findAny
        //10.sum

        //ParallelStream : help to preform operation on stream concurrently taking advantage of multicore cpu
        //fork join pool implementation in multithreading



    }
}
