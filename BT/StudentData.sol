// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract StudentData {
    // Structure
    struct Student {
        uint256 rollNo;
        string name;
        uint256 marks;
    }

    // Array of structures
    Student[] public students;

    event StudentAdded(uint256 rollNo, string name, uint256 marks);
    event FallbackCalled(address sender, uint256 value, bytes data);

    // Add a student to the array
    function addStudent(uint256 _rollNo, string memory _name, uint256 _marks) public {
        students.push(Student(_rollNo, _name, _marks));
        emit StudentAdded(_rollNo, _name, _marks);
    }

    // Get one student by index
    function getStudent(uint256 index) public view returns (uint256, string memory, uint256) {
        require(index < students.length, "Invalid index");
        Student memory s = students[index];
        return (s.rollNo, s.name, s.marks);
    }

    // Total number of students
    function getCount() public view returns (uint256) {
        return students.length;
    }

    // Fallback: runs when an unknown function is called or ETH is sent with data
    fallback() external payable {
        emit FallbackCalled(msg.sender, msg.value, msg.data);
    }

    // Receive: runs when plain ETH is sent with no data
    receive() external payable {
        emit FallbackCalled(msg.sender, msg.value, "");
    }
}