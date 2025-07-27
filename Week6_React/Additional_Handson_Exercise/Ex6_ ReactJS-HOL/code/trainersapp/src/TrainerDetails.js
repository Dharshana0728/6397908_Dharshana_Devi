import React from "react";
import trainers from "./TrainersMock";
import { useParams, Link } from "react-router-dom";

function TrainerDetail() {
  const { id } = useParams();
  const trainer = trainers.find(t => t.TrainerId === Number(id));

  if (!trainer) {
    return (
      <div>
        <h2>Trainer Not Found</h2>
        <Link to="/trainers">Back to List</Link>
      </div>
    );
  }
  return (
    <div>
      <h2>Trainer Details</h2>
      <p><strong>Name:</strong> {trainer.Name}</p>
      <p><strong>Email:</strong> {trainer.Email}</p>
      <p><strong>Phone:</strong> {trainer.Phone}</p>
      <p><strong>Technology:</strong> {trainer.Technology}</p>
      <p><strong>Skills:</strong> {trainer.Skills}</p>
      <Link to="/trainers">Back to List</Link>
    </div>
  );
}

export default TrainerDetail;
