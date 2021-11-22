using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class MovingCube : MonoBehaviour
{
    public static MovingCube CurrentCube { get; private set; }
    public static MovingCube LastCube { get; private set; }
    public MoveDirection MoveDirection { get; internal set; }

    [SerializeField]
    private float moveSpeed = 1f;


    private void OnEnable()
    {
        if (LastCube == null)
        {
            LastCube = GameObject.Find("Start").GetComponent<MovingCube>();
        }
            
        CurrentCube = this;
        GetComponent<Renderer>().material.color = GetRandomColor();

        transform.localScale = new Vector3(LastCube.transform.localScale.x, transform.localScale.y, LastCube.transform.localScale.z);
    }

    private Color GetRandomColor()
    {
        return new Color(UnityEngine.Random.Range(0, 1f), UnityEngine.Random.Range(0, 1f), UnityEngine.Random.Range(0, 1f));
    }

    void Update()
    {
        if(MoveDirection == MoveDirection.Z)
            transform.position += transform.forward * Time.deltaTime * moveSpeed;
        else
            transform.position += transform.right * Time.deltaTime * moveSpeed;
    }

    internal void Stop()
    {
        moveSpeed = 0;
        float hangover;
        if (MoveDirection == MoveDirection.Z)
            hangover = transform.position.z - LastCube.transform.position.z;
        else
            hangover = transform.position.x - LastCube.transform.position.x;

        float max = MoveDirection == MoveDirection.Z ? LastCube.transform.localScale.z : LastCube.transform.localScale.x;
        if (Mathf.Abs(hangover) >= max)
        {
            LastCube = null;  
            CurrentCube = null;
            SceneManager.LoadScene(0);
        }

        float direction = hangover > 0 ? 1f : -1f;
        if(MoveDirection==MoveDirection.Z)
            SplitCubeOnZ(hangover, direction);
        else
            SplitCubeOnX(hangover, direction);

        LastCube = this;
    }

    private void SplitCubeOnX(float hangover, float direction)//OK
    {
        float newXSize = LastCube.transform.localScale.x - Mathf.Abs(hangover);
        float fallingBlockSize = transform.localScale.x - newXSize;

        float newXPostion = LastCube.transform.position.x + (hangover / 2);
        transform.localScale = new Vector3(newXSize, transform.localScale.y, transform.localScale.z);
        transform.position = new Vector3(newXPostion, transform.position.y,transform.position.z );

        float cubeEdge = transform.position.x + (newXSize / 2f * direction);
        float fallingBlockXPostion = cubeEdge + fallingBlockSize / 2f * direction;

        SpawnDropCube(fallingBlockXPostion, fallingBlockSize);
    }

    private void SplitCubeOnZ(float hangover, float direction)//OK
    {
        float newZSize = LastCube.transform.localScale.z - Mathf.Abs(hangover);
        float fallingBlockSize = transform.localScale.z - newZSize;

        float newZPostion = LastCube.transform.position.z + (hangover / 2);
        transform.localScale = new Vector3(transform.localScale.x, transform.localScale.y, newZSize);
        transform.position = new Vector3(transform.position.x, transform.position.y, newZPostion);

        float cubeEdge = transform.position.z + (newZSize / 2f * direction);
        float fallingBlockZPostion = cubeEdge + fallingBlockSize / 2f * direction;

        SpawnDropCube(fallingBlockZPostion, fallingBlockSize);
    }

    void SpawnDropCube(float fallingBlockZPosition, float fallingBlockSize) //OK
    {
        var cube = GameObject.CreatePrimitive(PrimitiveType.Cube);
        if(MoveDirection == MoveDirection.Z)
        {
            cube.transform.localScale = new Vector3(transform.localScale.x, transform.localScale.y, fallingBlockSize);
            cube.transform.position = new Vector3(transform.position.x, transform.position.y, fallingBlockZPosition);
        }
        else
        {
            cube.transform.localScale = new Vector3(fallingBlockSize, transform.localScale.y, transform.localScale.z);
            cube.transform.position = new Vector3(fallingBlockZPosition, transform.position.y, transform.position.z);
        }
       

        cube.AddComponent<Rigidbody>();
        cube.GetComponent<Renderer>().material.color = GetComponent<Renderer>().material.color;
        Destroy(cube.gameObject, 1f);
    }
}
